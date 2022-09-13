package com.example.constraintlayout_navigation.old_Listview

//        button.setOnClickListener { Toast.makeText(MyApplication.context,"id button ",Toast.LENGTH_LONG).show()}
//赋值逻辑写在这,不能写上面
//        val MusicList = ArrayList<Musicitem>()
//        MusicList.add(Musicitem("Apple", R.drawable.apple_pic))
//        MusicList.add(Musicitem("Banana", R.drawable.banana_pic))
//        MusicList.add(Musicitem("Orange", R.drawable.orange_pic))
//        MusicList.add(Musicitem("Watermelon", R.drawable.watermelon_pic))
//        MusicList.add(Musicitem("Pear", R.drawable.pear_pic))
//        MusicList.add(Musicitem("Grape", R.drawable.grape_pic))
//        MusicList.add(Musicitem("Pineapple", R.drawable.pineapple_pic))
//        MusicList.add(Musicitem("Strawberry", R.drawable.strawberry_pic))
//        MusicList.add(Musicitem("Cherry", R.drawable.cherry_pic))
//        MusicList.add(Musicitem("Mango", R.drawable.mango_pic))
//        MusicList.add(Musicitem("Mango", R.drawable.mango_pic))
//        val adapter = MusicAdapter(MyApplication.context, R.layout.music_linear_listitem, MusicList)
//        fun buildLocalDatas() :List<ListBean> {
//           var  beans = ArrayList<ListBean>()
//            beans.add(
//                ListBean(
//                    "0",
//                    "现在就听"
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Apple",
//                    R.drawable.apple_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Banana",
//                    R.drawable.banana_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Orange",
//                    R.drawable.orange_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Watermelon",
//                    R.drawable.watermelon_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Pear",
//                    R.drawable.pear_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Grape",
//                    R.drawable.grape_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Apple",
//                    R.drawable.apple_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Banana",
//                    R.drawable.banana_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Orange",
//                    R.drawable.orange_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Watermelon",
//                    R.drawable.watermelon_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Pear",
//                    R.drawable.pear_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Grape",
//                    R.drawable.grape_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Apple",
//                    R.drawable.apple_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Banana",
//                    R.drawable.banana_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Orange",
//                    R.drawable.orange_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Watermelon",
//                    R.drawable.watermelon_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Pear",
//                    R.drawable.pear_pic
//                )
//            )
//            beans.add(
//                ListBean(
//                    "1",
//                    "Grape",
//                    R.drawable.grape_pic
//                )
//            )
//            return beans;
//        }
//        val adapter =
//            Listadapter(
//                MyApplication.context,
//                R.layout.music_linear_listitem,
//                buildLocalDatas()
//            )
//        Log.d("adaptererror",adapter.isEmpty.toString())
//         listView.adapter = adapter