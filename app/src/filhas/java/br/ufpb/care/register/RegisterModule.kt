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
        val patient = UserKind(name = R.string.patient, description = R.string.patient_description, icon = R.drawable.patient)
        val caregiver = UserKind(name = R.string.caregiver, description = R.string.caregiver_description, icon = R.drawable.caregiver)
        val supportGroup = UserKind(name = R.string.support_group, description = R.string.support_group_description, icon = R.drawable.support_group)

        return listOf(caregiver, supportGroup, patient)
    }

}