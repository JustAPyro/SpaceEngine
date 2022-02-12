package com.pyredevelopment.engine.systems;

public class NetworkSystem extends SuperSystem {

    @Override
    public void startup() {
        systemName = "Network";
    }

    @Override
    public void systemLoop() {

    }

    @Override
    public void shutdown() {
        super.close();
    }
}
