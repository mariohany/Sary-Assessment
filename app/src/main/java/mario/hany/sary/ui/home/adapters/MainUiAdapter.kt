package mario.hany.sary.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mario.hany.sary.databinding.SectionItemBinding
import mario.hany.sary.models.Section
import mario.hany.sary.ui.home.holders.SectionViewHolder

class MainUiAdapter(val list: List<Section>): RecyclerView.Adapter<SectionViewHolder>()  {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val binding = SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(list[position])
    }
}