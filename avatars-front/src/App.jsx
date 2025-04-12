import { useState } from "react";

import SideMenu from "./components/SideMenu";
import Home from "./components/Home";
import CreateAgent from "./components/CreateAgent/CreateAgent";
import AgentListDisplay from "./components/AgentListDisplay/AgentListDisplay";
import { getAllEventHosts, getAllInfluencers } from "./http";

function App() {
  const [activeTab, setActiveTab] = useState("Home");

  const renderTab = () => {
    switch (activeTab) {
      case "Home":
        return <Home />;
      case "Create Agent":
        return <CreateAgent />;
      case "Event Hosts":
        return <AgentListDisplay
          key={activeTab}
          activeTab={activeTab}
          getAgents={getAllEventHosts}
          title="Event Host"
        />;
      case "Influencers":
        return <AgentListDisplay
          key={activeTab}
          activeTab={activeTab}
          getAgents={getAllInfluencers}
          title="Influencer"
        />;
      default:
        return null;
    }
  };

  return (
    <div className="app">
      <SideMenu setActiveTab={setActiveTab} activeTab={activeTab} />
      <div className="content">{renderTab()}</div>
    </div>
  );
}

export default App
