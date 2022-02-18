package mario.hany.sary.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import mario.hany.sary.databinding.FragmentHomeBinding
import mario.hany.sary.models.Banner
import mario.hany.sary.models.Section
import mario.hany.sary.ui.home.adapters.MainUiAdapter
import mario.hany.sary.ui.home.viewmodel.HomeViewModel
import mario.hany.sary.ui.home.viewmodel.HomeViewState
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val bannerList:MutableList<Banner> by lazy { mutableListOf() }
    private val catalogList:MutableList<Section> by lazy { mutableListOf() }
    private val mainUiAdapter: MainUiAdapter by lazy { MainUiAdapter(catalogList) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadHomeScreen()
        bindViews()
        bindObservers()
    }

    private fun bindViews() {
        _binding?.apply {
            LinearLayoutManager(requireContext(), VERTICAL, false).also {
                sectionsRv.layoutManager = it
                sectionsRv.adapter = mainUiAdapter
            }
            slider.registerLifecycle(viewLifecycleOwner)
            slider.carouselListener = object: CarouselListener {
                override fun onClick(position: Int, carouselItem: CarouselItem) {
                    bannerList[position].link?.let{
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun bindObservers() {
        _binding?.apply {
            viewModel.viewState.observe(viewLifecycleOwner) {
                when(it){
                    is HomeViewState.Loading -> {
                        showLoader(it.state)
                    }
                    is HomeViewState.Banners -> {
                        bannerList.clear()
                        bannerList.addAll(it.list)
                        slider.setData(it.list.map { CarouselItem(it.image)})
                    }
                    is HomeViewState.Catalog -> {
                        catalogList.clear()
                        catalogList.addAll(it.list)
                        mainUiAdapter.notifyDataSetChanged()
                    }
                    is HomeViewState.SpecialOrder -> {
                        specialOrderView.isVisible = true
                    }
                    is HomeViewState.Error -> {
                        Toast.makeText(requireContext(), it.msg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun showLoader(state: Boolean){
        _binding?.apply {
            loader.isVisible = state
            mainLayout.isVisible = !state
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}