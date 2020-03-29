package com.topList.android.ui.search.holder

import android.view.View
import com.topList.android.R
import com.topList.android.R2
import com.topList.android.api.model.SearchItem
import com.topList.android.utils.TimeFormatUtils
import com.zhihu.android.sugaradapter.Layout
import com.zhihu.android.sugaradapter.SugarHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.feed_item.*

/**
 * @author yyf
 * @since 03-21-2020
 */
@Layout(R2.layout.search_item)
class SearchHolder(
    override val containerView: View
) : SugarHolder<SearchItem>(containerView), LayoutContainer {

    override fun onBindData(data: SearchItem) {
        feedItemSubject.text = data.title.trim()
        feedItemBody.text = data.desc.trim()
        feedItemByLine.text = context.getString(R.string.feed_item_byline, data.type, TimeFormatUtils.getTime(containerView.context, data.createTime.toLong()))
        feedItemAvatar.setImageURI(data.img)
    }

}