import { useState } from "react";

import { createAvatarGenerateImage } from "../../http";

export default function Appearance({ onNext, agentData, setAgentData }) {
    const [isLoading, setIsLoading] = useState(false);

    async function handleGenerateImage() {
        const newAgentData = {};
        setIsLoading(true);

        newAgentData.nationality = document.getElementById('nationality').value;
        newAgentData.agentAge = document.getElementById('agentAge').value;
        newAgentData.gender = document.getElementById('gender').value;
        newAgentData.skinTone = document.getElementById('skinTone').value;
        newAgentData.hairLength = document.getElementById('hairLength').value;
        newAgentData.hairShape = document.getElementById('hairShape').value;
        newAgentData.hairColor = document.getElementById('hairColor').value;
        newAgentData.eyesColor = document.getElementById('eyesColor').value;
        newAgentData.eyelashesLength = document.getElementById('eyelashesLength').value;

        const responseData = await createAvatarGenerateImage(newAgentData);

        setAgentData(prevAgentData => {
            return {
                ...prevAgentData,
                id: responseData.id,
                nationality: newAgentData.nationality,
                agentAge: newAgentData.agentAge,
                gender: newAgentData.gender,
                skinTone: newAgentData.skinTone,
                hairLength: newAgentData.hairLength,
                hairShape: newAgentData.hairShape,
                hairColor: newAgentData.hairColor,
                eyesColor: newAgentData.eyesColor,
                eyelashesLength: newAgentData.eyelashesLength,
                image: responseData.imageURL
            }
        });
        setIsLoading(false);
    }

    const disabled = (agentData === null || isLoading) ? true : false;

    return (
        <div className="create-agent-content">
            <div className="left-side">
                <div className="create-agent-layout">
                    <div className="appearance-grid">
                        <div className="single-column-input">
                            <label>Nationality</label>
                            <div>
                                <input id="nationality" className='input-text' placeholder="Enter agent's nationality" type="text" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Age</label>
                            <div>
                                <input id="agentAge" className='input-text' placeholder="Enter agent's age" type="number" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Gender</label>
                            <div>
                                <select id="gender" className="input-dropdown">
                                    <option value="">Select agent's gender</option>
                                    <option value="athletic">Male</option>
                                    <option value="slim">Female</option>
                                </select>
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Skin Tone</label>
                            <div>
                                <input id="skinTone" className='input-text' placeholder="Enter agent's skin tone" type="text" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Hair Length</label>
                            <div>
                                <input id="hairLength" className='input-text' placeholder="Enter agent's hair length" type="text" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Hair Shape</label>
                            <div>
                                <input id="hairShape" className='input-text' placeholder="Enter agent's hair shape" type="text" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Hair Color</label>
                            <div>
                                <input id="hairColor" className='input-text' placeholder="Enter agent's hair color" type="text" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Eyes Color</label>
                            <div>
                                <input id="eyesColor" className='input-text' placeholder="Enter agent's eyes color" type="text" />
                            </div>
                        </div>
                        <div className="single-column-input">
                            <label>Eyelashes Length</label>
                            <div>
                                <input id="eyelashesLength" className='input-text' placeholder="Enter agent's eyelashes length" type="text" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="right-side">
                {!agentData && !isLoading && <div className="avatar-image" style={{ border: '1px dashed #ccc' }}></div>}
                {!agentData && isLoading && <div className="avatar-image" style={{ border: '1px dashed #ccc' }}><div className="spinner"></div><p>Image is loading..</p></div>}
                {agentData && !isLoading && <img src={`data:image/png;base64,${agentData.image}`} alt="Generated Image" className="avatar-image" />}
                {agentData && isLoading && <div className="avatar-image" style={{ border: '1px dashed #ccc' }}><div className="spinner"></div><p>Image is loading..</p></div>}
                <button className="refresh-button" onClick={() => handleGenerateImage()}>{agentData ? 'Regenerate' : 'Generate image'}</button>
                <div className="navigation-buttons">
                    <button disabled={true} className="back-button">Back</button>
                    <button disabled={disabled} onClick={onNext} className="next-button">Next</button>
                </div>
            </div>
        </div>
    );
}