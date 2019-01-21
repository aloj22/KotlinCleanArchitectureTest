package com.ninetyninetest.app.ui.list

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninetyninetest.R
import com.ninetyninetest.app.util.Util
import com.ninetyninetest.domain.Company
import kotlinx.android.synthetic.main.company_item_layout.view.*


/**
 * Adapter for displaying @see Company
 */
class CompanyAdapter(private val onCompanyClickedListener: (Int) -> Unit) : RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {


    private val items = ArrayList<Company>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompanyViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.company_item_layout, parent, false))

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    /**
     * Update items
     * @param newItems New items to be shown
     */
    fun updateItems(newItems: List<Company>) {
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
                    = items[oldItemPosition].id == newItems[newItemPosition].id

            override fun getOldListSize() = items.size

            override fun getNewListSize() = newItems.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)
                    = items[oldItemPosition] == newItems[newItemPosition]
        }).dispatchUpdatesTo(this)

        items.run {
            clear()
            addAll(newItems)
        }
    }


    /**
     * Company view holder
     */
    inner class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(company: Company) {
            itemView.run {
                companyRIC.text = company.ric
                companyName.text = company.name
                companySharePrice.text = Util.formatAmount(company.sharePrice)
                setOnClickListener {
                    onCompanyClickedListener.invoke(company.id)
                }
            }
        }

    }
}