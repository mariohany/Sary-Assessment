package mario.hany.sary.data.models

data class BaseResponse<T,Y>(
    val result: T?,
    val other: Y?,
    val message: String?,
    val status:Boolean
)
