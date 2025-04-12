import { useState } from "react";


export default function LayoutItem({ item, onItemClick }) {
    const [isHovered, setHover] = useState(false);

    return (
        <div className="event-host">
            <div
                className="event-host-image"
                onMouseOver={() => setHover(true)}
                onMouseLeave={() => setHover(false)}
            >
                <img src={`data:image/png;base64,${item.image}`} />
                {isHovered && (
                    <button className="hover-button" onClick={onItemClick}>Create video</button>
                )}
            </div>
            <div className="event-host-name">
                <span>{item.agentName}</span>
            </div>
        </div>
    );
}