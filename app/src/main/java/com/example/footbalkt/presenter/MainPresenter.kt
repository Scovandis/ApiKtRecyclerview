package com.example.footbalkt.presenter

import com.example.footbalkt.api.ApiRepository
import com.example.footbalkt.api.TheSportDBApi
import com.example.footbalkt.model.TeamResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson)
{
    fun getTeamList(lenguage : String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(lenguage)),
                TeamResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}

