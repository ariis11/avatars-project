import { useState } from "react";

import Header from "./Header";
import Appearance from "./Appearance";
import Characteristics from "./Characteristics";
import Finish from "./Finish";

export default function CreateAgent() {
    const [currentStage, setCurrentStage] = useState('Appearance');
    const [agentData, setAgentData] = useState(null);

    const renderTab = () => {
        switch (currentStage) {
            case "Appearance":
                return <Appearance
                    onNext={() => setCurrentStage('Characteristics')}
                    agentData={agentData}
                    setAgentData={setAgentData}
                />;
            case "Characteristics":
                return <Characteristics
                    onNext={() => setCurrentStage('Finish')}
                    agentData={agentData}
                    setAgentData={setAgentData}
                />;
            case "Knowledge Sources":
                return <Appearance />;
            case "Finish":
                return <Finish />;
            default:
                return null;
        }
    };

    return (
        <div className="create-agent">
            <Header currentStage={currentStage} setCurrentStage={setCurrentStage} />
            {renderTab()}
        </div>
    );
}

{/*  */ }