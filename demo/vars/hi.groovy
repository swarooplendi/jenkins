def call(Map config = [:]) {
    sh " echo Hello ${config.person}. Today your meeting is fixed with ${config.master}."
}

