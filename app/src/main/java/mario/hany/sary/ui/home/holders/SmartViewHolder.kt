package mario.hany.sary.ui.home.holders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mario.hany.sary.databinding.SmartItemBinding
import mario.hany.sary.models.Data

class SmartViewHolder(private val binding: SmartItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Data) {
        binding.apply {
            Glide.with(itemView).load(data.image).into(iconIv)
            data.name?.let { nameTv.text = it }
        }
    }
}