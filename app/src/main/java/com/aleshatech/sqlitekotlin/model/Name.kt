package com.aleshatech.sqlitekotlin.model

class Name {
    var id:Int = 0
    var name:String? = null
    var mobile:String? = null
    var email:String? = null

    constructor(id:Int ,userName:String){
        this.id = id
        this.name = userName
    }
    constructor(userName:String,mobile:String,email:String){
        this.name = userName
        this.mobile = mobile
        this.email= email
    }


}