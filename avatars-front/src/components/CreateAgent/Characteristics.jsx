import { addCharacteristics } from "../../http";

export default function Characteristics({ onNext, agentData, setAgentData }) {
    function handleNext() {
        const newAgentData = {};

        newAgentData.id = agentData.id;
        newAgentData.name = document.getElementById('name').value;
        newAgentData.voice = document.getElementById('voice').value;
        newAgentData.language = document.getElementById('language').value;
        newAgentData.type = document.getElementById('type').value;

        addCharacteristics(newAgentData);
        setAgentData(prevAgentData => {
            return {
                ...prevAgentData,
                name: newAgentData.name,
                type: newAgentData.type,
                voice: newAgentData.voice,
                language: newAgentData.language
            }
        });
        onNext();
    }

    return (
        <div className="characteristics">
            <div className="create-agent-layout" style={{ marginTop: '8%'}}>
                <div className="single-column-input">
                    <label>Name</label>
                    <div>
                        <input id="name" className='input-text' placeholder="Enter agent name" type="text" />
                    </div>
                </div>
                <div className="single-column-input">
                    <label>Type</label>
                    <div>
                        <select id="type" className="input-dropdown">
                            <option value="">Select agent type</option>
                            <option value="host">Event Host</option>
                            <option value="influencer">Influencer</option>
                        </select>
                    </div>
                </div>
                <div className="single-column-input">
                    <label>Voice</label>
                    <div>
                        <select id="voice" className="input-dropdown">
                            <option value="">Select agent voice</option>
                            <option value="alloy">Alloy</option>
                            <option value="echo">Echo</option>
                            <option value="fable">Fable</option>
                            <option value="onyx">Onyx</option>
                            <option value="nova">Nova</option>
                            <option value="shimmer">Shimmer</option>
                        </select>
                    </div>
                </div>
                <div className="single-column-input">
                    <label>Language</label>
                    <div>
                        <select id="language" className="input-dropdown">
                            <option value="">Select agent language</option>
                            <option value="english">English</option>
                        </select>
                    </div>
                </div>
            </div>
            <div className="characteristics-navigation-buttons">
                <button className="back-button">Back</button>
                <button className="next-button" onClick={handleNext}>Next</button>
            </div>
        </div>
    );
}