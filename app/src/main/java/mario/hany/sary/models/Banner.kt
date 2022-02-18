package mario.hany.sary.models

import com.google.gson.annotations.SerializedName

data class Banner(
    val branch: Int?,
    @SerializedName("button_text")val buttonText: String?,
    @SerializedName("created_at")val createdAt: String?,
    val description: String?,
    @SerializedName("expiry_date") val expiryDate: String?,
    @SerializedName("expiry_status") val expiryStatus: Boolean?,
    val id: Int?,
    val image: String?,
    @SerializedName("is_available") val isAvailable: Boolean?,
    val level: String?,
    val link: String?,
    val photo: String?,
    val priority: Int?,
    @SerializedName("start_date") val startDate: String?,
    val title: String?
)