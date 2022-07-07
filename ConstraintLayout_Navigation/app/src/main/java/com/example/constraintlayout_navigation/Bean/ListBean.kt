package com.example.constraintlayout_navigation.Bean

open class ListBean {
    lateinit var text:String
    var type:String="-1"
    lateinit var name:String
    var img: Int=-1
    init{}
    constructor(type:String,txt:String)
    {
        text=txt
        this.type=type
    }
    constructor(type:String,name:String,img:Int)
    {
        this.img=img
        this.name=name
        this.type=type
    }
}