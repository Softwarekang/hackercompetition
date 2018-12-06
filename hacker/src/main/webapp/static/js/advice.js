window.onload = function (){
    new Vue({
        el:'#box',
        data:{
            myData: [],
            username: '',
            details: '',
            nowIndex: -100
        },
        methods:{
            add: function(){
                this.myData.push({
                    name:this.username,
                    age:this.details
                });
                this.username='';
                this.details=''
            },
            deleteMsg: function(n){
                if (n==-2) {
                    this.myData=[];
                } else{
                    this.myData.splice(n,1);
                }
            }
        }
    })
}