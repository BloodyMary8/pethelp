import com.google.gson.annotations.SerializedName

data class Environment (

    @SerializedName("children") val children : Boolean? = null,
    @SerializedName("dogs") val dogs : Boolean? = null,
    @SerializedName("cats") val cats : Boolean? = null
)