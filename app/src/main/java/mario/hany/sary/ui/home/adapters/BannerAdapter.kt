package mario.hany.sary.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mario.hany.sary.databinding.BannerItemBinding
import mario.hany.sary.models.Data
import mario.hany.sary.ui.home.holders.BannerViewHolder

class BannerAdapter(val list: List<Data>): RecyclerView.Adapter<BannerViewHolder>()  {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(list[position])
    }
}