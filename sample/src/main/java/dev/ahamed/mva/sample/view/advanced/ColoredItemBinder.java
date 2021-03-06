/*
 * Copyright 2017 Riyaz Ahamed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ahamed.mva.sample.view.advanced;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dev.ahamed.mva.sample.R;
import dev.ahamed.mva.sample.data.model.ColoredItem;
import mva2.adapter.ItemBinder;
import mva2.adapter.ItemViewHolder;

public class ColoredItemBinder extends ItemBinder<ColoredItem, ColoredItemBinder.ViewHolder> {

  @Override public ViewHolder createViewHolder(ViewGroup parent) {
    return new ViewHolder(inflate(parent, R.layout.item_number));
  }

  @Override public void bindViewHolder(ViewHolder holder, ColoredItem item) {
    holder.textView.setText(String.valueOf(item.getNumber()));
    holder.textView.setBackgroundColor(item.getColor());
  }

  @Override public boolean canBindData(Object item) {
    return item instanceof ColoredItem;
  }

  static final class ViewHolder extends ItemViewHolder<ColoredItem> {

    TextView textView;

    ViewHolder(View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.text_view);

      itemView.setOnLongClickListener(view -> {
        startDrag();
        return true;
      });
    }

    @Override public int getDragDirections() {
      return ItemTouchHelper.UP
          | ItemTouchHelper.DOWN
          | ItemTouchHelper.LEFT
          | ItemTouchHelper.RIGHT;
    }
  }
}
