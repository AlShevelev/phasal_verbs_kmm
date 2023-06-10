package com.shevelev.phrasalverbs.ui.features.editgroups.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shevelev.phrasalverbs.core.ui.theme.ColorsGeneral
import com.shevelev.phrasalverbs.domain.entities.Card

@Composable
internal fun CardSeparator(
    priorItemsTotalHeight: Dp?,
    listHeight: Dp,
    modifier: Modifier = Modifier,
    onDrop: (Card) -> Unit,
) {
    DropTarget<Card>(
        onDrop = onDrop,
    ) { isInbound ->
        val height = if (priorItemsTotalHeight != null &&
            listHeight - priorItemsTotalHeight >= CardListDimens.separatorHeight
        ) {
            (listHeight - priorItemsTotalHeight).coerceAtLeast(CardListDimens.separatorHeight)
        } else {
            CardListDimens.separatorHeight
        }

        val backgroundColor = if (isInbound && height == CardListDimens.separatorHeight) {
            ColorsGeneral.Green.copy(alpha = 1f)
        } else {
            Color.Transparent
        }

        Box(
            modifier = modifier
                .padding(vertical = CardListDimens.separatorPadding)
                .height(height)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(5.dp),
                ),
        )
    }
}
