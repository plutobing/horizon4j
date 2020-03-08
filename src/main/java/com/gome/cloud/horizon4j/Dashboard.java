package com.gome.cloud.horizon4j;

import com.gome.cloud.horizon4j.exceptions.NoSuchComponentException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by pluto on 1/10/16.
 */
public abstract class Dashboard extends Horizon4jComponent implements Registrable {

    protected Map<String, Panel> registry = new HashMap<String, Panel>(16);

    protected String defaultPanel;

    protected Set<String> panels = new HashSet<String>(16);

    protected Set<String> permissions = new HashSet<String>(16);

    protected boolean supports_tenants;

    public Dashboard(String name, String slug, String defaultPanel,
                     String[] panels, String[] permissions, boolean supports_tenants) {
        super(name, slug);
        this.defaultPanel = defaultPanel;
        this.supports_tenants = supports_tenants;

        if (panels != null) {
            for (String panel : panels) {
                this.panels.add(panel);
            }
        }

        if (permissions != null) {
            for (String permission : permissions) {
                this.permissions.add(permission);
            }
        }
    }

    @Override
    public String getAbstractUrlPath() {
        String abstractUrlPath;
        if (registry.containsKey(defaultPanel)){
            abstractUrlPath = registry.get(defaultPanel).getAbstractUrlPath();
        } else {
            throw new NoSuchComponentException("No such panel named [" + this.defaultPanel + "].");
        }
        return abstractUrlPath;
    }

    public void register(Namable t) {
        if (! Panel.class.isInstance(t)) {
            throw new ClassCastException("The instance expect [com.gome.cloud.horizon4j.Panel], actual [" + t.getClass().getName() + "]");
        }
        registry.put(t.getSlug(), (Panel)t);
    }

    public Namable unregister(String key) {
        if (! this.registry.containsKey(key)) {
            throw new NoSuchElementException("No such element in this registry named [" + key + "]");
        }
        return this.registry.get(key);
    }

    public Panel[] getPanelInfos() {
        Panel[] panels = new Panel[registry.size()];
        registry.values().toArray(panels);
        return panels;
    }

    public String getDefaultPanel() {
        return defaultPanel;
    }

    public void setDefaultPanel(String defaultPanel) {
        this.defaultPanel = defaultPanel;
    }

    public Set<String> getPanels() {
        return panels;
    }

    public void setPanels(Set<String> panels) {
        this.panels = panels;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public boolean isSupports_tenants() {
        return supports_tenants;
    }

    public void setSupports_tenants(boolean supports_tenants) {
        this.supports_tenants = supports_tenants;
    }

}
