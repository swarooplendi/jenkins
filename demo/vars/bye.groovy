def call(Map config = [:]) {
    sh " echo bye ${config.person}. Today your meeting is completed with ${config.master}."
}
