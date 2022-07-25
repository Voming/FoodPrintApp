package com.example.foodprintapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 하단 탭이 눌렸을 때 화면을 전환하기 위해선 이벤트 처리하기 위해 BottomNavigationView 객체 생성
        var bottomNavi = findViewById(R.id.bottomNavi) as BottomNavigationView

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bottomNavi.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_calendar -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val calendarFragment = calendarFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.Main_Frame, calendarFragment).commit()
                }
                R.id.action_recipe -> {
                    val recipeFragment = recipeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.Main_Frame, recipeFragment).commit()
                }
                R.id.action_search -> {
                    val searchFragment = searchFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.Main_Frame, searchFragment).commit()
                }
                R.id.action_mypage -> {
                    val mypageFragment = mypageFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.Main_Frame, mypageFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.action_calendar
        }
    }
}