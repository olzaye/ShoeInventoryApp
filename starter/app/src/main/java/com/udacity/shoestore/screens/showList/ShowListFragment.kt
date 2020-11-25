package com.udacity.shoestore.screens.showList

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShowListBinding
import com.udacity.shoestore.screens.MainActivity


class ShowListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding = DataBindingUtil.inflate<FragmentShowListBinding>(
            inflater,
            R.layout.fragment_show_list,
            container,
            false
        )

        var linearLayout = initHorizontalLinerLayout()

        (activity as? MainActivity)?.viewModel?.showList?.observe(viewLifecycleOwner, {
            binding.showLinearLayout.takeIf { it.childCount > 0 }?.removeAllViews()

            it.forEachIndexed { index, shoe ->
                context?.let { c ->
                    val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    params.weight = 1.0f
                    val shoeView = ShoeView(c).apply {
                        layoutParams = params
                    }
                    shoeView.fabOnClickListener { v ->
                        Navigation.findNavController(v)
                            .navigate(
                                ShowListFragmentDirections.actionFragmentShowListToShoeDetailFragment(
                                    shoe
                                )
                            )
                    }
                    shoeView.setShoeName(shoe.name)
                    linearLayout.addView(shoeView)

                    if (index != 0 && (index + 1) % 2 == 0) {
                        linearLayout.takeIf { it.childCount > 0 }?.let {
                            binding.showLinearLayout.addView(it)
                        }
                        linearLayout = initHorizontalLinerLayout()
                    } else if (it.size % 2 != 0 && index == it.size - 1) {
                        linearLayout.takeIf { it.childCount > 0 }?.let {
                            binding.showLinearLayout.addView(it)
                        }
                    }
                }
            }
        })

        return binding.root
    }

    private fun initHorizontalLinerLayout(): LinearLayout {
        return LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                2f
            )
            orientation = LinearLayout.HORIZONTAL
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}