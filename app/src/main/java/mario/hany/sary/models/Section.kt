package mario.hany.sary.models

import com.google.gson.annotations.SerializedName

data class Section(
    val data: List<Data>?,
    @SerializedName("data_type") val dataType: String?,
    val id: Int?,
    @SerializedName("row_count") val rowCount: Int?,
    @SerializedName("show_title") val showTitle: Boolean?,
    val title: String?,
    @SerializedName("ui_type") val uiType: String?
)