package mario.hany.sary.models


import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("business_status")
    val businessStatus: BusinessStatus?,
    @SerializedName("show_special_order_view")
    val showSpecialOrderView: Boolean?,
    @SerializedName("show_vat")
    val showVat: Boolean?,
    @SerializedName("uncompleted_profile_settings")
    val uncompletedProfileSettings: UncompletedProfileSettings?
)