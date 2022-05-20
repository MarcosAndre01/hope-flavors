package br.ufpb.care.register.model

import br.ufpb.care.R
import br.ufpb.care.register.model.UserKind
import br.ufpb.care.register.model.UserKinds

object UserKindsImpl : UserKinds {
    val patient = UserKind(name = R.string.patient, description = R.string.patient_description, icon = R.drawable.logo)
    val caregiver = UserKind(name = R.string.caregiver, description = R.string.caregiver_description, icon = R.drawable.logo)
    val supportGroup = UserKind(name = R.string.support_group, description = R.string.support_group_description, icon = R.drawable.logo)

    override val value = listOf(patient, caregiver, supportGroup)
}