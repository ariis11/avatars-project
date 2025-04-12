export async function getAllAvatars() {
    const response = await fetch('http://localhost:8080/api/avatar/getAllAvatars');

    if (!response.ok) {
        throw new Error('Failed to update user data.');
    }

    return await response.json();
}

export async function getAllEventHosts() {
    const response = await fetch('http://localhost:8080/api/avatar/getAllEventHosts');

    if (!response.ok) {
        throw new Error('Failed to update user data.');
    }

    return await response.json();
}

export async function getAllInfluencers() {
    const response = await fetch('http://localhost:8080/api/avatar/getAllInfluencers');

    if (!response.ok) {
        throw new Error('Failed to update user data.');
    }

    return await response.json();
}

export async function createAvatarGenerateImage(agentData) {
    const url = new URL('http://localhost:8080/api/avatar/createAvatarGenerateImage');

    url.searchParams.append('nationality', agentData.nationality);
    url.searchParams.append('agentAge', agentData.agentAge);
    url.searchParams.append('gender', agentData.gender);
    url.searchParams.append('skinTone', agentData.skinTone);
    url.searchParams.append('hairLength', agentData.hairLength);
    url.searchParams.append('hairShape', agentData.hairShape);
    url.searchParams.append('hairColor', agentData.hairColor);
    url.searchParams.append('eyesColor', agentData.eyesColor);
    url.searchParams.append('eyelashesLength', agentData.eyelashesLength);

    const response = await fetch(url);
    debugger;

    if (!response.ok) {
        throw new Error('Failed to create avatar image.');
    }

    // const blob = await response.blob();
    // const imageURL = URL.createObjectURL(blob);

    // return imageURL;

    const data = await response.json(); // Parse response as JSON
    const avatarId = data.id;
    const imageBlob = data.image;

    return { id: avatarId, imageURL: imageBlob };
}

export async function addCharacteristics(characteristics) {
    try {
        const response = await fetch('http://localhost:8080/api/avatar/addCharacteristics', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(characteristics)
        });

        if (!response.ok) {
            throw new Error('Failed to add characteristics');
        }
    } catch (error) {
        console.error('Failed to add characteristics:', error);
    }
}

export async function getVideo() {
    const response = await fetch('http://localhost:8080/api/avatar/getVideo');

    debugger;
    
    if (!response.ok) {
        throw new Error('Failed to fetch video');
    }

    const videoBlob = await response.blob();
    const videoURL = URL.createObjectURL(videoBlob);

    return videoURL;
}