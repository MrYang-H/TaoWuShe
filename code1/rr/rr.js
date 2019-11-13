Page({
  data: {
    goods: '',
    num: 1,
    carArray: [
      
      {
        carImage: '../../image/huaweiMate30.png',
        carTitle: 'HUAWEIMate30',
        carPrice: '¥5799.00',
        carNum: 1,
        carShow: true
      },

      
      

    ]
  },
  
  toPay: function () {
    wx.navigateTo({
      url: '../pay/pay'
    })
  },
  find: function () {
    var self = this
    
  },
  carReduce: function(){
    var that = this

    that.setData({
      num: that.data.num - 1
    })
  },
  carAdd: function () {
    var that = this

    that.setData({
      num : that.data.num + 1
    })
  }
})