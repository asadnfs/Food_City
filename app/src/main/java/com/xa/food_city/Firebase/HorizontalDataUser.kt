package com.xa.food_city.Firebase


class HorizontalDataUser {
    var id: String? = null
    var name: String? = null
    var cost: String? = null
    var product_type:String? = null
    var vally_type:String? = null
    var info:String? = null
    var image:String? = null

    constructor(){}
    constructor(id: String?, name: String?, cost: String?, product_type: String?, vally_type: String?, info:String?, image:String?) {
        this.id = id
        this.name = name
        this.cost = cost
        this.product_type = product_type
        this.vally_type = vally_type
        this.info = info
        this.image = image
    }
}