package kr.co.jjjoonngg.demostagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var plusFragment: PlusFragment
    private lateinit var marketFragment: MarketFragment
    private lateinit var profileFragment: ProfileFragment

    private var lastActivePage: Fragment? = null
    private val fragmentTransaction
        get() = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragments(savedInstanceState)
        initNavigationTab()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (!::homeFragment.isInitialized && !::searchFragment.isInitialized && !::plusFragment.isInitialized
            && !::marketFragment.isInitialized && !::profileFragment.isInitialized
        ) {
            return
        }

        if (homeFragment.activity != null && searchFragment.activity != null && plusFragment.activity != null
            && marketFragment.activity != null && profileFragment.activity != null
        ) {
            with(supportFragmentManager) {
                putFragment(outState, FRAGMENT_ID_HOME, homeFragment)
                putFragment(outState, FRAGMENT_ID_SEARCH, searchFragment)
                putFragment(outState, FRAGMENT_ID_PLUS, plusFragment)
                putFragment(outState, FRAGMENT_ID_MARKET, marketFragment)
                putFragment(outState, FRAGMENT_ID_PROFILE, profileFragment)
            }
        }
        super.onSaveInstanceState(outState)
    }

    private fun initFragments(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            with(supportFragmentManager) {
                homeFragment = getFragment(savedInstanceState, FRAGMENT_ID_HOME) as HomeFragment?
                    ?: HomeFragment()
                searchFragment =
                    getFragment(savedInstanceState, FRAGMENT_ID_SEARCH) as SearchFragment?
                        ?: SearchFragment()
                plusFragment = getFragment(savedInstanceState, FRAGMENT_ID_PLUS) as PlusFragment?
                    ?: PlusFragment()
                marketFragment =
                    getFragment(savedInstanceState, FRAGMENT_ID_MARKET) as MarketFragment?
                        ?: MarketFragment()
                profileFragment =
                    getFragment(savedInstanceState, FRAGMENT_ID_PROFILE) as ProfileFragment?
                        ?: ProfileFragment()
            }
        } ?: run {
            homeFragment = HomeFragment()
            searchFragment = SearchFragment()
            plusFragment = PlusFragment()
            marketFragment = MarketFragment()
            profileFragment = ProfileFragment()
        }

        lastActivePage = supportFragmentManager.findFragmentById(R.id.frameContainer)
        val containerId = R.id.frameContainer
        homeFragment.apply {
            if (!isAdded) {
                fragmentTransaction.add(containerId, this).commitAllowingStateLoss()
                lastActivePage = this
            }
        }
        searchFragment.apply {
            if (!isAdded) {
                fragmentTransaction.add(containerId, this).hide(this).commitAllowingStateLoss()
            }
        }
        plusFragment.apply {
            if (!isAdded) {
                fragmentTransaction.add(containerId, this).hide(this).commitAllowingStateLoss()
            }
        }
        marketFragment.apply {
            if (!isAdded) {
                fragmentTransaction.add(containerId, this).hide(this).commitAllowingStateLoss()
            }
        }
        profileFragment.apply {
            if (!isAdded) {
                fragmentTransaction.add(containerId, this).hide(this).commitAllowingStateLoss()
            }
        }
    }

    private fun initNavigationTab() {
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuHome -> {
                    if (!isCurrentActivePage(homeFragment)) {
                        showPage(PAGE_IDX_HOME)
                    }
                }
                R.id.menuSearch -> {
                    if (!isCurrentActivePage(searchFragment)) {
                        showPage(PAGE_IDX_SEARCH)
                    }
                }
                R.id.menuPlus -> {
                    if (!isCurrentActivePage(plusFragment)) {
                        showPage(PAGE_IDX_PLUS)
                    }
                }
                R.id.menuMarket -> {
                    if (!isCurrentActivePage(marketFragment)) {
                        showPage(PAGE_IDX_MARKET)
                    }
                }
                R.id.menuProfile -> {
                    if (!isCurrentActivePage(profileFragment)) {
                        showPage(PAGE_IDX_PROFILE)
                    }
                }
            }
            true
        }
    }

    private fun showPage(pageIndex: Int) {
        val currentPage = supportFragmentManager.fragments[pageIndex]
        lastActivePage?.let {
            fragmentTransaction.hide(it).show(currentPage).commitAllowingStateLoss()
            lastActivePage = currentPage
            val currentItemId = bottomNav.menu.getItem(pageIndex).itemId
            bottomNav.menu.findItem(currentItemId).setChecked(true)
        } ?: return
    }

    private fun isCurrentActivePage(currentPage: Fragment) = lastActivePage == currentPage

    companion object {
        const val FRAGMENT_ID_HOME = "fragment-home"
        const val FRAGMENT_ID_SEARCH = "fragment-search"
        const val FRAGMENT_ID_PLUS = "fragment-plus"
        const val FRAGMENT_ID_MARKET = "fragment-market"
        const val FRAGMENT_ID_PROFILE = "fragment-profile"

        const val PAGE_IDX_HOME = 0
        const val PAGE_IDX_SEARCH = 1
        const val PAGE_IDX_PLUS = 2
        const val PAGE_IDX_MARKET = 3
        const val PAGE_IDX_PROFILE = 4
    }
}