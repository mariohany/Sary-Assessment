package mario.hany.sary.ui.home.holders

import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mario.hany.sary.databinding.SectionItemBinding
import mario.hany.sary.models.DataType
import mario.hany.sary.models.Section
import mario.hany.sary.models.UiType
import mario.hany.sary.ui.home.adapters.BannerAdapter
import mario.hany.sary.ui.home.adapters.GroupAdapter
import mario.hany.sary.ui.home.adapters.SmartAdapter

class SectionViewHolder(private val binding: SectionItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(section: Section) {
        binding.apply {
            section.showTitle?.let { titleTv.isVisible = it }
            section.title?.let { titleTv.text = it }
            section.data?.let {
                when(section.uiType){
                    UiType.GRID.value ->{
                        GridLayoutManager(itemView.context, section.rowCount?:4).also { manager ->
                            categoryRv.layoutManager = manager
                        }
                    }
                    UiType.LINEAR.value ->{
                        LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false).also { manager ->
                            categoryRv.layoutManager = manager
                        }
                    }
                    UiType.SLIDER.value ->{
                        LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false).also { manager ->
                            categoryRv.layoutManager = manager
                        }
                    }
                }

                when(section.dataType){
                    DataType.SMART.value -> {
                        SmartAdapter(it).also { adapter ->
                            categoryRv.adapter = adapter
                        }
                    }
                    DataType.GROUP.value -> {
                        GroupAdapter(it).also { adapter ->
                            categoryRv.adapter = adapter
                        }
                    }
                    DataType.BANNER.value -> {
                        BannerAdapter(it).also { adapter ->
                            categoryRv.adapter = adapter
                        }
                    }
                }
            }
        }
    }
}