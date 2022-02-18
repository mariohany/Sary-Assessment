package mario.hany.sary.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mario.hany.sary.databinding.GroupItemBinding
import mario.hany.sary.models.Data
import mario.hany.sary.ui.home.holders.GroupViewHolder

class GroupAdapter(val list: List<Data>): RecyclerView.Adapter<GroupViewHolder>()  {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = GroupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(list[position])
    }
}