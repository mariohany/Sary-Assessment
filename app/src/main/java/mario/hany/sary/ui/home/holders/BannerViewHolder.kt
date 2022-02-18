package mario.hany.sary.ui.home.holders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mario.hany.sary.databinding.BannerItemBinding
import mario.hany.sary.models.Data

class BannerViewHolder(private val binding: BannerItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Data) {
        binding.apply {
            Glide.with(itemView).load(data.image).into(imageIv)
//            data.name?.let { nameTv.text = it }
        }
    }
}