package mario.hany.sary.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mario.hany.sary.databinding.SmartItemBinding
import mario.hany.sary.models.Data
import mario.hany.sary.ui.home.holders.SmartViewHolder

class SmartAdapter(val list: List<Data>): RecyclerView.Adapter<SmartViewHolder>()  {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartViewHolder {
        val binding = SmartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SmartViewHolder, position: Int) {
        holder.bind(list[position])
    }
}