package com.example.patshopclient.home.activity

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.android_patshopclient.R
import com.example.patshopclient.common.config.PathConfig
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.common.pictureselector.GlideEngine
import com.example.patshopclient.home.POJO.ProductAlbumPOJO
import com.example.patshopclient.home.adapter.ProductAlbumAdapter
import com.example.patshopclient.home.dialog.DatePickerDialog
import com.example.patshopclient.home.dialog.TimePickerDialog
import com.example.patshopclient.home.factory.ManageSaleViewModelFactory
import com.example.patshopclient.home.viewmodel.ManageSaleViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.common_toolbar.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.*

@Route(path = PathConfig.ADDPRODUCT)
class AddProductActivity : BaseMvvmActivity<ManageSaleViewModel>() {

    //商品封面图
    private var picList = mutableListOf<ProductAlbumPOJO>()
    private var productPicAdapter = ProductAlbumAdapter(picList)

    //商品图片册
    private var albumList = mutableListOf<ProductAlbumPOJO>()
    private var productAlbumAdapter = ProductAlbumAdapter(albumList)
    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog

    override fun onBindLayout(): Int {
        return R.layout.activity_add_product
    }

    private var topicTypeList = arrayListOf("生活充值", "游戏点卷", "手机数码", "手办模型", "美妆好物", "生活百货")

    override fun initView() {
        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "参拍"
        iv_back.visibility = View.VISIBLE
        val productAlbumPOJO = ProductAlbumPOJO()
        productAlbumPOJO.type = 1
        productPicAdapter.addChildClickViewIds(R.id.ll_album, R.id.iv_close)
        productPicAdapter.addData(productAlbumPOJO)
        recycler_pics.adapter = productPicAdapter
        productAlbumAdapter.addChildClickViewIds(R.id.ll_album, R.id.iv_close)
        productAlbumAdapter.addData(productAlbumPOJO)
        recycler_albums.adapter = productAlbumAdapter
        datePickerDialog = DatePickerDialog(context)
        datePickerDialog.datePickerListener = datePickerListener
        timePickerDialog = TimePickerDialog(context)
        timePickerDialog.timePickerListener = timePickerListener
    }

    override fun initData() {

    }

    override fun initListener() {
        super.initListener()
        iv_back.setOnClickListener {
            finish()
        }

        ll_category_name.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                    .setTitle("商品分类")
                    .setSingleChoiceItems(topicTypeList.toTypedArray(), 0) { dialogInterface: DialogInterface, i: Int ->
                        tv_select_category.text = topicTypeList[i]
                        tv_select_category.visibility = View.VISIBLE
                        dialogInterface.dismiss()
                    }.create().show()
        }

        ll_select_date.setOnClickListener {
            datePickerDialog.show()
        }

        ll_select_time.setOnClickListener {
            timePickerDialog.show()
        }

        btn_complete.setOnClickListener {
            if (!checkPostContent())
                return@setOnClickListener
            val picFiles = mutableListOf<MultipartBody.Part>()
            val picPaths = mViewModel.picPathList.value
            if (picPaths != null) {
                for (path in picPaths) {
                    val imageFile = File(path)
                    val requestBody = imageFile.asRequestBody("application/json".toMediaTypeOrNull())
                    val imagePart = MultipartBody.Part.createFormData("pics", imageFile.name, requestBody)
                    picFiles.add(imagePart)
                }
            }
            val imageFiles = mutableListOf<MultipartBody.Part>()
            val imagePaths = mViewModel.imagePathList.value
            if (imagePaths != null) {
                for (path in imagePaths) {
                    val imageFile = File(path)
                    val requestBody = imageFile.asRequestBody("application/json".toMediaTypeOrNull())
                    val imagePart = MultipartBody.Part.createFormData("albumsPics", imageFile.name, requestBody)
                    imageFiles.add(imagePart)
                }
            }

            mViewModel.postAddProduct(et_name.text.toString(), et_sub_name.text.toString(), tv_select_category.text.toString(),
                    getBidCountDown(), et_start_price.text.toString().toDouble(), et_markup.text.toString().toDouble(),
                    et_market_price.text.toString().toDouble(), picFiles, imageFiles)
        }

        productPicAdapter.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.ll_album -> {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())
                            .loadImageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java
                            .forResult(object : OnResultCallbackListener<LocalMedia> {
                                override fun onResult(result: MutableList<LocalMedia>?) {
                                    Log.d("huangqiubin", "成功选择照片!")
                                    val imageList = mutableListOf<String>()
                                    if (result != null) {
                                        for (localMedia in result) {
                                            imageList.add(localMedia.path)
                                        }
                                    }
                                    mViewModel.picPathList.value?.let { imageList.addAll(it) }
                                    mViewModel.picPathList.value = imageList
                                }

                                override fun onCancel() {
                                    Log.d("huangqiubin", "取消选择照片!")
                                }

                            })
                }
                R.id.iv_close -> {
                    val imageList = mViewModel.picPathList.value
                    imageList?.removeAt(position)
                    mViewModel.picPathList.postValue(imageList)

                }
            }
        }

        productAlbumAdapter.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.ll_album -> {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())
                            .loadImageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java
                            .forResult(object : OnResultCallbackListener<LocalMedia> {
                                override fun onResult(result: MutableList<LocalMedia>?) {
                                    Log.d("huangqiubin", "成功选择照片!")
                                    val imageList = mutableListOf<String>()
                                    if (result != null) {
                                        for (localMedia in result) {
                                            imageList.add(localMedia.path)
                                        }
                                    }
                                    mViewModel.imagePathList.value?.let { imageList.addAll(it) }
                                    mViewModel.imagePathList.value = imageList
                                }

                                override fun onCancel() {
                                    Log.d("huangqiubin", "取消选择照片!")
                                }
                            })
                }
                R.id.iv_close -> {
                    val imageList = mViewModel.imagePathList.value
                    imageList?.removeAt(position)
                    mViewModel.imagePathList.postValue(imageList)
                }

            }
        }

    }

    override fun onBindViewModel(): Class<ManageSaleViewModel> {
        return ManageSaleViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return ManageSaleViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {
        mViewModel.addProductLiveEvent.observe(this, Observer {
            if (it.data != 1) {
                MaterialAlertDialogBuilder(context).setMessage("发布商品失败,请稍后重试")
                        .setPositiveButton("确认") { dialog, _ ->
                            dialog.dismiss()

                        }.create().show()
                return@Observer
            }
            Toast.makeText(context, "发布商品成功！", Toast.LENGTH_SHORT).show()
            finish()
        })

        mViewModel.picPathList.observe(this, Observer {
            val picsList = mutableListOf<ProductAlbumPOJO>()
            for (s in it) {
                val productPicAlbun = ProductAlbumPOJO()
                productPicAlbun.imgPath = s
                productPicAlbun.type = 0
                picsList.add(productPicAlbun)
            }
            var productSpec = ProductAlbumPOJO()
            productSpec.type = 1
            picsList.add(productSpec)
            productPicAdapter.setNewData(picsList)
        })

        mViewModel.imagePathList.observe(this, Observer {
            val albumList = mutableListOf<ProductAlbumPOJO>()
            for (s in it) {
                val productPicAlbun = ProductAlbumPOJO()
                productPicAlbun.imgPath = s
                productPicAlbun.type = 0
                albumList.add(productPicAlbun)
            }
            var productSpec = ProductAlbumPOJO()
            productSpec.type = 1
            albumList.add(productSpec)
            productAlbumAdapter.setNewData(albumList)
        })

    }

    private fun checkPostContent(): Boolean {
        if (et_name.text.isEmpty()) {
            Toast.makeText(context, "商品名可不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (et_sub_name.text.isEmpty()) {
            Toast.makeText(context, "商品详细描述可不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (et_start_price.text.isEmpty()) {
            Toast.makeText(context, "商品起拍价可不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (et_markup.text.isEmpty()) {
            Toast.makeText(context, "商品加价幅度可不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (et_market_price.text.isEmpty()) {
            Toast.makeText(context, "商品市场价可不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (tv_select_category.text.isEmpty()) {
            Toast.makeText(context, "商品分类可不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (getBidCountDown() <= System.currentTimeMillis()) {
            Toast.makeText(context, "截拍时间不能早于当前～", Toast.LENGTH_SHORT).show()
            return false
        }

        if (mViewModel.picPathList.value.isNullOrEmpty()) {
            Toast.makeText(context, "商品首页图不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        if (mViewModel.imagePathList.value.isNullOrEmpty()) {
            Toast.makeText(context, "商品相册集不能为空哦～", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun getBidCountDown(): Long {
        //截拍时间
        val date = tv_select_date.text.split("/")
        val time = tv_select_time.text.split(":")
        val calendar = Calendar.getInstance()
        calendar.set(date[0].toInt(), date[1].toInt(), date[2].toInt(), time[0].toInt(), time[1].toInt())
        return calendar.timeInMillis
    }

    private val datePickerListener = object : DatePickerDialog.DatePickerListener {
        @SuppressLint("SetTextI18n")
        override fun onDatePicKerListener(year: Int, month: Int, day: Int) {
            tv_select_date.text = "${year}/${month + 1}/${day}"
        }
    }

    private val timePickerListener = object : TimePickerDialog.TimePickerListener {

        @SuppressLint("SetTextI18n")
        override fun onTimePicKerListener(hour: Int, minute: Int) {
            tv_select_time.text = "${hour}:${minute}"
        }
    }

}
