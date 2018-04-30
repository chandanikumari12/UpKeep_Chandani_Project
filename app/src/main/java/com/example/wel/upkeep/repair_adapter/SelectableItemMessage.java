package com.example.wel.upkeep.repair_adapter;


/**
 * Created by 103 on 12/21/2017.
 */




public class SelectableItemMessage extends Item
{
    private boolean isSelected = false;

    public SelectableItemMessage(Item item,boolean isSelected)
    {
        super(item.getName(),item.getSurname(),item.getCreatedon(),item.getIsread(),item.getVideo(),item.getType());
        this.isSelected = isSelected;
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean selected)
    {
        isSelected = selected;
    }
}