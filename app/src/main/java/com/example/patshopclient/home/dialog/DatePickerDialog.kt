package com.example.patshopclient.home.dialog

import android.content.Context
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import com.example.android_patshopclient.R
import com.example.patshopclient.common.basedialog.BaseCenterDialog
import java.util.*

/**
 * Created by qiubin on 2020/5/19.
 * Describe:日期选择器
 */
class DatePickerDialog(context: Context) : BaseCenterDialog(context) {
    lateinit var btnOk: TextView
    lateinit var btnCancel: TextView
    lateinit var datePicker: DatePicker
    lateinit var datePickerListener: DatePickerListener
    lateinit var calendar: Calendar

    override fun getLayoutId() = R.layout.dialog_date_picker

    override fun initView() {
        super.initView()
        btnOk = rootView.findViewById(R.id.btn_ok)
        btnCancel = rootView.findViewById(R.id.btn_cancel)
        calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        datePicker = rootView.findViewById(R.id.date_picker)
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null)
        initViewEvent()
    }

    private fun initViewEvent() {
        btnCancel.setOnClickListener {
            dismiss()
        }

        btnOk.setOnClickListener {
            datePickerListener.onDatePicKerListener(datePicker.year, datePicker.month, datePicker.dayOfMonth)
            dismiss()
        }
    }

    interface DatePickerListener {
        fun onDatePicKerListener(year: Int, month: Int, day: Int)
    }


}