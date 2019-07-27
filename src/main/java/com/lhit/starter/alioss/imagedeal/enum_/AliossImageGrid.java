package com.lhit.starter.alioss.imagedeal.enum_;

public enum AliossImageGrid {

    nw("nw","north west"),
    north("north","north"),
    ne("ne","north east"),
    west("west","west"),
    center("center","center"),
    east("east","east"),
    sw("sw","soutch west"),
    south("south","south"),
    se("se","south east");


    /*
        nw      north       ne
        west    center      east
        sw      south       se
     */



    private String grid;

    private String desc;

    AliossImageGrid(String grid, String desc) {
        this.grid = grid;
        this.desc = desc;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
