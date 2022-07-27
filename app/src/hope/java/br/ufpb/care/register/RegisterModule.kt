package br.ufpb.care.register

import br.ufpb.care.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object RegisterModule {
    @Provides
    fun provideUserKinds(): List<UserKind> {
        val dependent = UserKind(name = R.string.dependent, description = R.string.dependent_description, icon = R.drawable.dependent)
        val codependent = UserKind(name = R.string.codependent, description = R.string.codependent_description, icon = R.drawable.codependent)
        val exDependent = UserKind(name = R.string.ex_dependent, description = R.string.ex_dependent_description, icon = R.drawable.ex_dependent)
        val specialist =  UserKind(name = R.string.specialist, description =  R.string.specialist_description, icon = R.drawable.specialist)
        val communicator = UserKind(name = R.string.communicator, description = R.string.communicator_description, icon = R.drawable.communicator)

        return listOf(dependent, codependent, exDependent, specialist, communicator)
    }

}