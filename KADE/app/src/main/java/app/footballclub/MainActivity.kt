package app.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import app.footballclub.R.attr.layoutManager
import app.footballclub.R.id.*
import app.footballclub.R.layout.item_list
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)


    }
    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                recyclerView {
                    name?.onClick {
                        startActivity<MainActivity>("name" to "{name.text}")

                    }
                }.lparams(width = matchParent, height = wrapContent)
                fun initData() {
                    val name = resources.getStringArray(R.array.club_name)
                    val image = resources.obtainTypedArray(R.array.club_image)
                    items.clear()
                    for (i in name.indices) {
                        items.add(Item(name[i],
                                image.getResourceId(i, 0)))
                    }

                    //Recycle the typed array
                    image.recycle()
                }
            }

        }
        //MutableList dari kelas Item.Kt
        private var items: MutableList<Item> = mutableListOf()


    }}
