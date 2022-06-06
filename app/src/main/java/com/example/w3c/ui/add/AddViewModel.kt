package com.example.w3c.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.w3c.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class AddViewModel : ViewModel() {
    val model = Model.newInstance(context)

    // Creates inputs for reference.
    val ids = TensorBuffer.createFixedSize(intArrayOf(1, 128), DataType.INT32)
    ids.loadBuffer(byteBuffer)
    val segmentIds = TensorBuffer.createFixedSize(intArrayOf(1, 128), DataType.INT32)
    segmentIds.loadBuffer(byteBuffer)
    val mask = TensorBuffer.createFixedSize(intArrayOf(1, 128), DataType.INT32)
    mask.loadBuffer(byteBuffer)

    // Runs model inference and gets result.
    val outputs = model.process(ids, segmentIds, mask)
    val probability = outputs.probabilityAsCategoryList

// Releases model resources if no longer used.
    model.close()
