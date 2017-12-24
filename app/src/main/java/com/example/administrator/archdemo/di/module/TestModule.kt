package com.example.administrator.archdemo.di.module

import com.example.administrator.archdemo.ArchApp
import com.example.administrator.archdemo.entity.TestEntity
import dagger.Module
import dagger.Provides

/**
 * @desc
 * @author Teaphy
 * @date 2017/12/24
 */
@Module
class TestModule (archApp: ArchApp){
	@Provides
	fun provideNumber(): TestEntity {
		return TestEntity(20)
	}
}