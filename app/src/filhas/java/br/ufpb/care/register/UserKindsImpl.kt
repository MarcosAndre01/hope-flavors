package br.ufpb.care.register

import br.ufpb.care.R

class UserKindsImpl : UserKinds {
    private val patient = UserKind(name = R.string.patient, description = R.string.patient_description, icon = R.drawable.patient)
    private val caregiver = UserKind(name = R.string.caregiver, description = R.string.caregiver_description, icon = R.drawable.caregiver)
    private val supportGroup = UserKind(name = R.string.support_group, description = R.string.support_group_description, icon = R.drawable.support_group)

    override val value = listOf(caregiver, supportGroup, patient)
}