package com.client.googlenotes.ui.view.checkabletextinput

import android.content.Context
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import com.client.googlenotes.R
import com.client.googlenotes.util.PASSWORD_MIN_LENGTH
import com.client.googlenotes.util.isValidEmail
import com.client.googlenotes.util.isValidPassword
import com.client.googlenotes.util.isValidPhone
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.min

/**
 * Created by Konstantin Aleksashin on 17/11/2018.
 *
 * Модификация TextInputLayout которая показывает ошибки ввода, производит валидацию полей
 * Тип поля задается параметром fieldType
 * Чтобы провалидировать поле, нужно вызвать метод getTextAndValidate
 * Он вернет экземпляр класса {@link ValidationResult)}, который содержит в себе результат проверки,
 * а также введенный юзером текст, к которому применили trim()
 */
class CheckableTextInputLayout : TextInputLayout {

    var passwordToggleChangeListener: PasswordToggleChangeListener? = null

    private lateinit var textViewError: AppCompatTextView
    private var fieldType: Int = EMAIL
    private var errorBackgroundColor: Int = ContextCompat.getColor(context, R.color.orange_red)
    private var colorControlNormal: Int = fetchNormalControlColor()
    private var needIgnoreFocusChange: Boolean = false
    private var error = ""

    companion object {
        private const val EMAIL = 0
        private const val PASSWORD = 1
        private const val FIO = 2
        private const val PHONE = 3
        private const val INN = 4

        private const val EXTRA_ERROR = "ru.handh.moedelo.ERROR"
        private const val EXTRA_NEED_IGNORE_FOCUS_CHANGE = "ru.handh.moedelo.IGNORE_FOCUS_CHANGE"
        private const val EXTRA_SUPER_STATE = "ru.handh.moedelo.SUPER_STATE"
    }

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    override fun onSaveInstanceState(): Parcelable? {
        val bundle = Bundle()
        bundle.putParcelable(EXTRA_SUPER_STATE, super.onSaveInstanceState())
        bundle.putString(EXTRA_ERROR, error)
        bundle.putBoolean(EXTRA_NEED_IGNORE_FOCUS_CHANGE, needIgnoreFocusChange)
        return bundle
    }

    public override fun onRestoreInstanceState(state: Parcelable?) {
        var bundleState = state
        if (bundleState is Bundle) {
            val bundle = bundleState as Bundle?
            bundle?.let {
                this.error = it.getString(EXTRA_ERROR) ?: ""
                this.needIgnoreFocusChange = it.getBoolean(EXTRA_NEED_IGNORE_FOCUS_CHANGE)
                bundleState = it.getParcelable(EXTRA_SUPER_STATE)
            }
        }
        super.onRestoreInstanceState(bundleState)
    }

    fun getTextAndValidate(canBeEmpty: Boolean = false, needShowError: Boolean = true): ValidationResult {
        val text = checkField(canBeEmpty, needShowError, true)
        val isValid = TextUtils.isEmpty(error)
        return ValidationResult(isValid, text)
    }

    fun getText(): String {
        return editText?.text.toString()
    }

    fun setNeedIgnoreFocusChange(ignoreFocusChange: Boolean) {
        this.needIgnoreFocusChange = ignoreFocusChange
    }

    override fun setError(errorText: CharSequence?) {
    }

    override fun setErrorEnabled(enabled: Boolean) {
    }

    override fun onDetachedFromWindow() {
        editText?.onFocusChangeListener = null
        super.onDetachedFromWindow()
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)

        if (editText != null) {
            editText?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    error = ""
                    updateError()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })

            editText?.setOnFocusChangeListener { _, hasFocus ->
                run {
                    if (!hasFocus) {
                        if (!needIgnoreFocusChange) {
                            checkField(true, true, false)
                        }
                    }

                    needIgnoreFocusChange = false
                }
            }
        }
    }

    override fun passwordVisibilityToggleRequested(shouldSkipAnimations: Boolean) {
        super.passwordVisibilityToggleRequested(shouldSkipAnimations)
        passwordToggleChangeListener?.onToggleChanged(editText?.transformationMethod == null)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        isErrorEnabled = false

        val array = context?.theme?.obtainStyledAttributes(
                attrs,
                R.styleable.CheckableTextInputLayout,
                0, 0)

        var errorTextApperance: Int = 0
        if (array != null) {
            fieldType = array.getInteger(R.styleable.CheckableTextInputLayout_fieldType, EMAIL)
            val colorRes = array.getResourceId(R.styleable.CheckableTextInputLayout_errorBackgroundColor, -1)
            if (colorRes >= 0) {
                errorBackgroundColor = ContextCompat.getColor(getContext(), colorRes)
            }
            errorTextApperance = array.getResourceId(R.styleable.CheckableTextInputLayout_errorTextAppearance, 0)
        }

        textViewError = AppCompatTextView(context)
        TextViewCompat.setTextAppearance(textViewError, errorTextApperance)
        addView(textViewError)
        setupBackgroundPainter()
        textViewError.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            override fun onPreDraw(): Boolean {
                val padding = editText?.paddingStart ?: 0
                textViewError.setPadding(padding, 0, padding, 0)
                textViewError.viewTreeObserver.removeOnPreDrawListener(this)
                return true
            }
        })
    }

    private fun checkField(canBeEmpty: Boolean, needShowError: Boolean, isExternalRequest: Boolean): String {
        var text = getText()

        when (fieldType) {
            EMAIL -> {
                text = text.trim()

                if (isExternalRequest) {
                    updateText(text)
                }

                if (needShowError) {
                    error = when {
                        TextUtils.isEmpty(text) -> context.getString(R.string.field_error_empty)
                        !isValidEmail(text) -> context.getString(R.string.field_error_email)
                        else -> ""
                    }
                } else {
                    error = ""
                }
            }
            PASSWORD -> {

                text = text.trim()

                if (isExternalRequest) {
                    updateText(text)
                }

                if (needShowError) {
                    error = when {
                        TextUtils.isEmpty(text) -> context.getString(R.string.field_error_empty)
                        !isValidPassword(text) -> context.getString(R.string.field_error_min_length, PASSWORD_MIN_LENGTH)
                        else -> ""
                    }
                } else {
                    error = ""
                }
            }
            PHONE -> {
                if (isExternalRequest) {
                    updateText(text)
                }

                text = text.trim().replace(" ", "")

                if (needShowError) {
                    error = when {
                        TextUtils.isEmpty(text) -> context.getString(R.string.field_error_empty)
                        !isValidPhone(text) -> context.getString(R.string.field_error_phone)
                        else -> ""
                    }
                } else {
                    error = ""
                }
            }
        }

        updateError()
        return text
    }

    private fun updateText(text: String) {
        val selection = editText?.selectionEnd ?: text.length
        editText?.setText(text)
        editText?.setSelection(min(text.length, selection))
    }

    private fun updateError() {
        textViewError.text = error
    }

    private fun setupBackgroundPainter() {
        viewTreeObserver.addOnGlobalLayoutListener {
            val background = editText?.background
            if (background != null) {
                if (TextUtils.isEmpty(error)) {
                    background.setColorFilter(colorControlNormal,
                            PorterDuff.Mode.SRC_IN)
                } else if (!TextUtils.isEmpty(error)) {
                    background.setColorFilter(errorBackgroundColor,
                            PorterDuff.Mode.SRC_IN)
                }
            }
        }
    }

    private fun fetchNormalControlColor(): Int {
        val typedValue = TypedValue()

        val a = context.obtainStyledAttributes(typedValue.data, intArrayOf(R.attr.colorControlNormal))
        val color = a.getColor(0, 0)

        a.recycle()
        return color
    }

    interface PasswordToggleChangeListener {
        fun onToggleChanged(isPasswordVisible: Boolean)
    }
}