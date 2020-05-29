package com.example.patshopclient.home.dialog

import android.content.Context
import android.os.Build
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import com.example.android_patshopclient.R
import com.example.patshopclient.common.basedialog.BaseCenterDialog
import java.util.*

/**
 * Created by qiubin on 2020/5/19.
 * Describe:日期选择器
 */
class TimePickerDialog(context: Context) : BaseCenterDialog(context) {
    lateinit var btnOk: TextView
    lateinit var btnCancel: TextView
    lateinit var timePicker: TimePicker
    lateinit var timePickerListener: TimePickerListener
    lateinit var calendar: Calendar

    override fun getLayoutId() = R.layout.dialog_time_picker

    override fun initView() {
        super.initView()
        btnOk = rootView.findViewById(R.id.btn_ok)
        btnCancel = rootView.findViewById(R.id.btn_cancel)
        calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        timePicker = rootView.findViewById(R.id.time_picker)
        timePicker.setIs24HourView(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.hour = calendar.get(Calendar.HOUR_OF_DAY)
            timePicker.minute = calendar.get(Calendar.MINUTE)
        } else {
            timePicker.currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            timePicker.currentMinute = calendar.get(Calendar.MINUTE)
        }
        initViewEvent()
    }

    private fun initViewEvent() {
        btnCancel.setOnClickListener {
            dismiss()
        }

        btnOk.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                timePickerListener.onTimePicKerListener(timePicker.hour, timePicker.minute)
            } else {
                timePickerListener.onTimePicKerListener(timePicker.currentHour, timePicker.currentMinute)
            }
            dismiss()
        }
    }

    interface TimePickerListener {
        fun onTimePicKerListener(hour: Int, minute: Int)
    }


}