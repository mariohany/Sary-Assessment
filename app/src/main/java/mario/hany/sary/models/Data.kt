package mario.hany.sary.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("empty_content_image") val emptyContentImage: String?,
    @SerializedName("empty_content_message") val emptyContentMessage: String?,
    @SerializedName("group_id") val groupId: Int?,
    @SerializedName("has_data") val hasData: Boolean?,
    val image: String?,
    val name: String?,
    @SerializedName("show_in_brochure_link") val showInBrochureLink: Boolean?,
    @SerializedName("show_unavailable_items") val showUnavailableItems: Boolean?
)