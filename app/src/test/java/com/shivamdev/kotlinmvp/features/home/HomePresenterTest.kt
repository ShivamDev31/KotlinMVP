package com.shivamdev.kotlinmvp.features.home

import com.nhaarman.mockito_kotlin.*
import com.shivamdev.kotlinmvp.data.model.GithubRepo
import com.shivamdev.kotlinmvp.data.remote.GithubApi
import com.shivamdev.kotlinmvp.dummy.USER_ID
import com.shivamdev.kotlinmvp.dummy.getUserRepos
import com.shivamdev.kotlinmvp.utils.RxSchedulersOverrideRule
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by shivam on 09/02/18.
 */

@RunWith(MockitoJUnitRunner::class)
class HomePresenterTest {

    @JvmField
    @Rule
    val overrideSchedulersRule = RxSchedulersOverrideRule()

    private val repoSingle = Single.just(getUserRepos())

    private var githubApi: GithubApi = mock {
        on { getGithubUserRepos(USER_ID) } doReturn repoSingle
    }

    private var view: HomeView = mock()

    private var presenter: HomePresenter? = null

    @Before
    fun setUp() {
        presenter = HomePresenter(githubApi)
        presenter?.attachView(view)
    }

    @Test
    fun testShowErrorWhenUserIdIsBlank() {
        presenter?.getUserRepos("")
        verify(view).showEmptyIdError()
    }

    @Test
    fun testShouldReturnUserReposWhenFetchingSuccess() {
        presenter?.getUserRepos(USER_ID)
        verify(view).showLoader()
        verify(view).showUserRepos(getUserRepos())
        verify(view).hideLoader()
    }

    @Test
    fun testShouldShowErrorWhenReposFetchingFails() {
        val exception = NullPointerException("User not found")
        val errorSingle = Single.error<List<GithubRepo>>(exception)
        whenever(githubApi.getGithubUserRepos(USER_ID)).thenReturn(errorSingle)
        presenter?.getUserRepos(USER_ID)
        verify(view).showLoader()
        verify(view, never()).showUserRepos(getUserRepos())
        verify(view).hideLoader()
    }

    @After
    fun tearDown() {
        presenter?.detachView()
    }

}