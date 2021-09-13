package com.tochapps.ceibatestapp.fake_view_model

import com.tochapps.ceibatestapp.fake_repository.data.local.FakeUserCacheRepository
import com.tochapps.ceibatestapp.fake_repository.data.remote.FakeUserDataRepository
import org.junit.Test

class MainViewModelTest {
    //FAKE REMOTE REPO
    private val remoRepo = FakeUserDataRepository()
    //FAKE LOCAL REPO
    private val localRepo = FakeUserCacheRepository()

    @Test
    fun `check if empty local db`(){
        assert(localRepo.getAllUser().isEmpty())
    }

    @Test
    fun `get all remote user and save`(){
        assert(remoRepo.getAllUser().isNotEmpty())
        localRepo.addAllUser(remoRepo.getAllUser())
        assert(localRepo.getAllUser().isNotEmpty())
    }

    @Test
    fun `search user post with id and check if exist`(){
        assert(remoRepo.getAllUser().isNotEmpty())
        localRepo.addAllUser(remoRepo.getAllUser())
        assert(localRepo.getAllUser().isNotEmpty())
        val userId = localRepo.getAllUser().firstOrNull()
        if (userId != null) {
            assert(remoRepo.getPostUser(userId.id).isNotEmpty())
        }else
            error("something is wrong to get id")
    }

}